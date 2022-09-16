Este paquete sirve para agregar las diferentes interfaces e 
implementaciones para la obtención de datos de una DB u
realizar peticiones a otros microservicios.
Se debe tener una interface Repository y una implementación de 
la misma en el caso de consumir un microservicio, en el caso de acceso a una DB
se crea únicamente la interfaz 


* repository

* ~~~java
  public interface CustomerRepository {
    Mono<ContractCustomerResponseDto> find(String identification, String identificationType);
  }
  ~~~

    * impl

* ~~~java
  @Component
  @RequiredArgsConstructor
  public class CustomerRepositoryImpl implements CustomerRepository {
      
  private final WebClientHelper webClientHelper;
  private final TransactionTrackingHelper transactionTrackingHelper;
        
  @Value("${url.get.customer.contract-data}")
  private String urlGetCustomerContractData;
      
  public Mono<ContractCustomerResponseDto> find(String identification, String identificationType){
    return webClientHelper.builder()
        .header(transactionTrackingHelper.getMdcHeaders()).build().get()
        .uri(urlGetCustomerContractData, identification, identificationType)
        .retrieve().bodyToMono(ContractCustomerResponseDto.class);
  }
  }
  ~~~
