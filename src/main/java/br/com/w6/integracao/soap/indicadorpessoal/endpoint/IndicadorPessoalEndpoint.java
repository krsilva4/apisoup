package br.com.w6.integracao.soap.indicadorpessoal.endpoint;


import br.com.w6.integracao.soap.mapeamentoxml.CustomerDetail;
import br.com.w6.integracao.soap.mapeamentoxml.GetCustomerDetailRequest;
import br.com.w6.integracao.soap.mapeamentoxml.GetCustomerDetailResponse;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.joox.JOOX.$;


@Endpoint
public class IndicadorPessoalEndpoint {

   /* @PayloadRoot(namespace = "http://klayrocha.com.br", localPart = "GetCustomerDetailRequest")
    @ResponsePayload
    public GetCustomerDetailResponse processIndicadorPessoal(@RequestPayload GetCustomerDetailRequest request){
        GetCustomerDetailResponse response = new GetCustomerDetailResponse();
        CustomerDetail customerDetail = new CustomerDetail();
        customerDetail.setId(1);
        customerDetail.setEmail("bod@gmail.com");
        customerDetail.setNome("bod");
        customerDetail.setTelefone("99999999");
        response.setCustomerDetail(customerDetail);
        return response;
    }*/

    @PayloadRoot(namespace = "http://klayrocha.com.br", localPart = "GetCustomerDetailRequest")
    @ResponsePayload
    public GetCustomerDetailResponse processIndicadorPessoal(@RequestPayload GetCustomerDetailRequest request,MessageContext messageContext){
        GetCustomerDetailResponse response = new GetCustomerDetailResponse();
        CustomerDetail customerDetail = new CustomerDetail();
        customerDetail.setId(1);
        customerDetail.setEmail("bod@gmail.com");
        customerDetail.setNome("bod");
        customerDetail.setTelefone("99999999");
        response.setCustomerDetail(customerDetail);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            messageContext.getRequest().writeTo(outputStream);
            String httpMessage = new String(outputStream.toByteArray());
            System.out.println($(httpMessage).find("cpf"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
