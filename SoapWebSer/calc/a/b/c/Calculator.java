
package a.b.c;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Calculator", targetNamespace = "http://c.b.a", wsdlLocation = "https://svn.apache.org/repos/asf/airavata/sandbox/xbaya-web/test/Calculator.wsdl")
public class Calculator
    extends Service
{

    private final static URL CALCULATOR_WSDL_LOCATION;
    private final static WebServiceException CALCULATOR_EXCEPTION;
    private final static QName CALCULATOR_QNAME = new QName("http://c.b.a", "Calculator");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://svn.apache.org/repos/asf/airavata/sandbox/xbaya-web/test/Calculator.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CALCULATOR_WSDL_LOCATION = url;
        CALCULATOR_EXCEPTION = e;
    }

    public Calculator() {
        super(__getWsdlLocation(), CALCULATOR_QNAME);
    }

    public Calculator(WebServiceFeature... features) {
        super(__getWsdlLocation(), CALCULATOR_QNAME, features);
    }

    public Calculator(URL wsdlLocation) {
        super(wsdlLocation, CALCULATOR_QNAME);
    }

    public Calculator(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CALCULATOR_QNAME, features);
    }

    public Calculator(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Calculator(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CalculatorPortType
     */
    @WebEndpoint(name = "CalculatorHttpsSoap11Endpoint")
    public CalculatorPortType getCalculatorHttpsSoap11Endpoint() {
        return super.getPort(new QName("http://c.b.a", "CalculatorHttpsSoap11Endpoint"), CalculatorPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CalculatorPortType
     */
    @WebEndpoint(name = "CalculatorHttpsSoap11Endpoint")
    public CalculatorPortType getCalculatorHttpsSoap11Endpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://c.b.a", "CalculatorHttpsSoap11Endpoint"), CalculatorPortType.class, features);
    }

    /**
     * 
     * @return
     *     returns CalculatorPortType
     */
    @WebEndpoint(name = "CalculatorHttpSoap11Endpoint")
    public CalculatorPortType getCalculatorHttpSoap11Endpoint() {
        return super.getPort(new QName("http://c.b.a", "CalculatorHttpSoap11Endpoint"), CalculatorPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CalculatorPortType
     */
    @WebEndpoint(name = "CalculatorHttpSoap11Endpoint")
    public CalculatorPortType getCalculatorHttpSoap11Endpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://c.b.a", "CalculatorHttpSoap11Endpoint"), CalculatorPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CALCULATOR_EXCEPTION!= null) {
            throw CALCULATOR_EXCEPTION;
        }
        return CALCULATOR_WSDL_LOCATION;
    }

}
