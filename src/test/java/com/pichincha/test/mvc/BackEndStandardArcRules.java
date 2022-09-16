package com.pichincha.test.mvc;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import java.util.Objects;

@AnalyzeClasses(packages = "com.pichincha.mvc")
public class BackEndStandardArcRules {

  @ArchTest
  ArchRule serviceRules = classes()
      .that().resideInAPackage("..service..")
      .should().onlyBeAccessed().byAnyPackage("..controller..", "..handler..", "..service..");

  @ArchTest
  ArchRule repository = classes()
      .that().resideInAPackage("..repository..")
      .should().onlyBeAccessed().byAnyPackage("..service..", "..repository..");

  @ArchTest
  ArchRule layers = layeredArchitecture()
      .optionalLayer("Controller").definedBy("..controller..")
      .optionalLayer("Handler").definedBy("..handler..")
      .optionalLayer("Util").definedBy("..util..")
      .optionalLayer("Helper").definedBy("..helper..")
      .layer("Service").definedBy("..service..")
      .layer("Repository").definedBy("..repository..")
      .layer("Model").definedBy("..model..")
      .layer("Configuration").definedBy("..configuration..")

      .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
      .whereLayer("Handler").mayOnlyBeAccessedByLayers("Configuration")
      .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller", "Service", "Handler")
      .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service")
      .allowEmptyShould(true);

  @ArchTest
  ArchRule implementations = classes().that().haveSimpleNameEndingWith("Impl")
      .should().resideInAPackage("..impl");


  @ArchTest
  void interfaceImplementations(JavaClasses classes) {
    classes.stream()
        .filter(JavaClass::isInterface)
        .map(clazz -> {
          try {
            return clazz.getClass().getClassLoader().loadClass(clazz.getFullName());
          } catch (ClassNotFoundException e) {
            return null;
          }
        })
        .filter(Objects::nonNull)
        .forEach(clazz -> classes().that().implement(clazz).should()
            .haveSimpleNameEndingWith("Impl").allowEmptyShould(true).check(classes));

  }

}
