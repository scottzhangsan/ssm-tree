package com.itdragon.util;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.ws.Service;
import javax.xml.namespace.QName;


public class WsClientUtils {
	 /**
     * 获取soap webservice
     * @param wsdlDocumentLocation
     *                  wsdl文档地址，e.g.http://esb01.jqdev.saic-gm.com:7005/esb/ws/wol/claim/v1?wsdl
     * @param serviceName
     *                  e.g.new QName("http://impl.ws.agent.service.dms.sgm.com/", "ClaimOperationWebServiceImplService")
     * @param webServiceClassType   webservice接口类型
     * @param <T>
     * @return
     * @author wangfl
     * create on 2017-10-20
     */
    public static <T> T getWebService(String wsdlDocumentLocation, QName serviceName, Class<T> webServiceClassType){
        //格式化wsdl document地址
        URL wsdlDocumentURL = null;
        try {
            wsdlDocumentURL = new URL(wsdlDocumentLocation);
        } catch (MalformedURLException e) {
            //logger.error("Can not initialize the wsdl from " + wsdlDocumentLocation);
        }

        //获取webService实现类
        @SuppressWarnings("restriction")
		T webService = Service.create(wsdlDocumentURL, serviceName).getPort(webServiceClassType);

        //添加日志拦截器
      //  addLoggingInterceptor(webService);

        return webService;
    }

    /**
     * 添加SOAP WEBSERVICE日志拦截器
     * @param webService
     * @author wangfl
     * create on 2017-10-20
     */
    /*public static void addLoggingInterceptor(Object webService){
        Client client = JaxWsClientProxy.getClient(webService);

        //输入流日志拦截器
        client.getInInterceptors().add(new LoggingInInterceptor());
        //输出流日志拦截器
        client.getOutInterceptors().add(new LoggingOutInterceptor());
    }*/

}
