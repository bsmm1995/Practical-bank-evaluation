Paquete donde se guardan las diferentes clases que contienen 
los endpoints de los servicios de nuestro proyecto. Ejemplo:

* controller

* ~~~ java
  @Slf4j
  @RequiredArgsConstructor
  @RestController
  @RequestMapping("/api/v2")
  public class CheckOfferController {
      
    private String commonHeaderCrdDeviceIdKey;
  
    @PostMapping(path = "/check/offer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponseDto> checkOffer(@RequestBody PersonDto personDto,
            @RequestHeader Map<String, String> headers) {
      
      headers.entrySet().forEach(mapEntry -> MDC.put(mapEntry.getKey(), mapEntry.getValue()));
      MDC.put(commonHeaderCrdSesionIdKey, commonHeaderCrdSesionIdKey);
  
      if (BooleanUtils.isFalse(validateCaptcha(personDto.getIdentification(), headers.get(RECAPTCHA_TOKEN)))) {
        return ResponseEntity.ok(CommonResponseDto.builder()
                .code(StatusCode.INVALID_RECAPTCHA.getCode())
                .message(StatusCode.INVALID_RECAPTCHA.getMessage()).build());
      }
  ~~~