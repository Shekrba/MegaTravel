
package com.example.demo.soapxml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client3 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddAccommodationResponse_QNAME = new QName("http://service.agent.megatravel.com/", "addAccommodationResponse");
    private final static QName _EditAccommodation_QNAME = new QName("http://service.agent.megatravel.com/", "editAccommodation");
    private final static QName _EditAccommodationResponse_QNAME = new QName("http://service.agent.megatravel.com/", "editAccommodationResponse");
    private final static QName _SOAPFaultException_QNAME = new QName("http://service.agent.megatravel.com/", "SOAPFaultException");
    private final static QName _SJedinicaXMLDTO_QNAME = new QName("http://service.agent.megatravel.com/", "SJedinicaXMLDTO");
    private final static QName _EditAccommodationUnit_QNAME = new QName("http://service.agent.megatravel.com/", "editAccommodationUnit");
    private final static QName _KomentarXMLDTO_QNAME = new QName("http://service.agent.megatravel.com/", "KomentarXMLDTO");
    private final static QName _AddAccommodationUnit_QNAME = new QName("http://service.agent.megatravel.com/", "addAccommodationUnit");
    private final static QName _CategoryXMLDTO_QNAME = new QName("http://service.agent.megatravel.com/", "CategoryXMLDTO");
    private final static QName _AdresaXMLDTO_QNAME = new QName("http://service.agent.megatravel.com/", "AdresaXMLDTO");
    private final static QName _EditAccommodationUnitResponse_QNAME = new QName("http://service.agent.megatravel.com/", "editAccommodationUnitResponse");
    private final static QName _AddAccommodationUnitResponse_QNAME = new QName("http://service.agent.megatravel.com/", "addAccommodationUnitResponse");
    private final static QName _AddAccommodation_QNAME = new QName("http://service.agent.megatravel.com/", "addAccommodation");
    private final static QName _SmestajXMLDTO_QNAME = new QName("http://service.agent.megatravel.com/", "SmestajXMLDTO");
    private final static QName _SOAPException_QNAME = new QName("http://service.agent.megatravel.com/", "SOAPException");
    private final static QName _UslugaXMLDTO_QNAME = new QName("http://service.agent.megatravel.com/", "UslugaXMLDTO");
    private final static QName _AccomodationTypeXMLDTO_QNAME = new QName("http://service.agent.megatravel.com/", "AccomodationTypeXMLDTO");

    /**
     * Create a new ObjectFactoryLogin that can be used to create new instances of schema derived classes for package: client2
     *
     */


    /**
     * Create an instance of {@link CategoryXMLDTO }
     *
     */
    public CategoryXMLDTO createCategoryXMLDTO() {
        return new CategoryXMLDTO();
    }

    /**
     * Create an instance of {@link AddAccommodationUnit }
     *
     */
    public AddAccommodationUnit createAddAccommodationUnit() {
        return new AddAccommodationUnit();
    }

    /**
     * Create an instance of {@link KomentarXMLDTO }
     *
     */
    public KomentarXMLDTO createKomentarXMLDTO() {
        return new KomentarXMLDTO();
    }

    /**
     * Create an instance of {@link EditAccommodationResponse }
     *
     */
    public EditAccommodationResponse createEditAccommodationResponse() {
        return new EditAccommodationResponse();
    }

    /**
     * Create an instance of {@link SOAPFaultException }
     *
     */

    /**
     * Create an instance of {@link SJedinicaXMLDTO }
     *
     */
    public SJedinicaXMLDTO createSJedinicaXMLDTO() {
        return new SJedinicaXMLDTO();
    }

    /**
     * Create an instance of {@link EditAccommodationUnit }
     *
     */
    public EditAccommodationUnit createEditAccommodationUnit() {
        return new EditAccommodationUnit();
    }

    /**
     * Create an instance of {@link AddAccommodationResponse }
     *
     */
    public AddAccommodationResponse createAddAccommodationResponse() {
        return new AddAccommodationResponse();
    }

    /**
     * Create an instance of {@link EditAccommodation }
     *
     */
    public EditAccommodation createEditAccommodation() {
        return new EditAccommodation();
    }

    /**
     * Create an instance of {@link AccomodationTypeXMLDTO }
     *
     */
    public AccomodationTypeXMLDTO createAccomodationTypeXMLDTO() {
        return new AccomodationTypeXMLDTO();
    }

    /**
     * Create an instance of {@link UslugaXMLDTO }
     *
     */
    public UslugaXMLDTO createUslugaXMLDTO() {
        return new UslugaXMLDTO();
    }

    /**
     * Create an instance of {@link AddAccommodation }
     *
     */
    public AddAccommodation createAddAccommodation() {
        return new AddAccommodation();
    }

    /**
     * Create an instance of {@link SmestajXMLDTO }
     *
     */
    public SmestajXMLDTO createSmestajXMLDTO() {
        return new SmestajXMLDTO();
    }

    /**
     * Create an instance of {@link SOAPException }
     *
     */


    /**
     * Create an instance of {@link AddAccommodationUnitResponse }
     *
     */
    public AddAccommodationUnitResponse createAddAccommodationUnitResponse() {
        return new AddAccommodationUnitResponse();
    }

    /**
     * Create an instance of {@link AdresaXMLDTO }
     *
     */
    public AdresaXMLDTO createAdresaXMLDTO() {
        return new AdresaXMLDTO();
    }

    /**
     * Create an instance of {@link EditAccommodationUnitResponse }
     *
     */
    public EditAccommodationUnitResponse createEditAccommodationUnitResponse() {
        return new EditAccommodationUnitResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAccommodationResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.agent.megatravel.com/", name = "addAccommodationResponse")
    public JAXBElement<AddAccommodationResponse> createAddAccommodationResponse(AddAccommodationResponse value) {
        return new JAXBElement<AddAccommodationResponse>(_AddAccommodationResponse_QNAME, AddAccommodationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditAccommodation }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.agent.megatravel.com/", name = "editAccommodation")
    public JAXBElement<EditAccommodation> createEditAccommodation(EditAccommodation value) {
        return new JAXBElement<EditAccommodation>(_EditAccommodation_QNAME, EditAccommodation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditAccommodationResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.agent.megatravel.com/", name = "editAccommodationResponse")
    public JAXBElement<EditAccommodationResponse> createEditAccommodationResponse(EditAccommodationResponse value) {
        return new JAXBElement<EditAccommodationResponse>(_EditAccommodationResponse_QNAME, EditAccommodationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SOAPFaultException }{@code >}}
     *
     */


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SJedinicaXMLDTO }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.agent.megatravel.com/", name = "SJedinicaXMLDTO")
    public JAXBElement<SJedinicaXMLDTO> createSJedinicaXMLDTO(SJedinicaXMLDTO value) {
        return new JAXBElement<SJedinicaXMLDTO>(_SJedinicaXMLDTO_QNAME, SJedinicaXMLDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditAccommodationUnit }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.agent.megatravel.com/", name = "editAccommodationUnit")
    public JAXBElement<EditAccommodationUnit> createEditAccommodationUnit(EditAccommodationUnit value) {
        return new JAXBElement<EditAccommodationUnit>(_EditAccommodationUnit_QNAME, EditAccommodationUnit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KomentarXMLDTO }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.agent.megatravel.com/", name = "KomentarXMLDTO")
    public JAXBElement<KomentarXMLDTO> createKomentarXMLDTO(KomentarXMLDTO value) {
        return new JAXBElement<KomentarXMLDTO>(_KomentarXMLDTO_QNAME, KomentarXMLDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAccommodationUnit }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.agent.megatravel.com/", name = "addAccommodationUnit")
    public JAXBElement<AddAccommodationUnit> createAddAccommodationUnit(AddAccommodationUnit value) {
        return new JAXBElement<AddAccommodationUnit>(_AddAccommodationUnit_QNAME, AddAccommodationUnit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoryXMLDTO }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.agent.megatravel.com/", name = "CategoryXMLDTO")
    public JAXBElement<CategoryXMLDTO> createCategoryXMLDTO(CategoryXMLDTO value) {
        return new JAXBElement<CategoryXMLDTO>(_CategoryXMLDTO_QNAME, CategoryXMLDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdresaXMLDTO }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.agent.megatravel.com/", name = "AdresaXMLDTO")
    public JAXBElement<AdresaXMLDTO> createAdresaXMLDTO(AdresaXMLDTO value) {
        return new JAXBElement<AdresaXMLDTO>(_AdresaXMLDTO_QNAME, AdresaXMLDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditAccommodationUnitResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.agent.megatravel.com/", name = "editAccommodationUnitResponse")
    public JAXBElement<EditAccommodationUnitResponse> createEditAccommodationUnitResponse(EditAccommodationUnitResponse value) {
        return new JAXBElement<EditAccommodationUnitResponse>(_EditAccommodationUnitResponse_QNAME, EditAccommodationUnitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAccommodationUnitResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.agent.megatravel.com/", name = "addAccommodationUnitResponse")
    public JAXBElement<AddAccommodationUnitResponse> createAddAccommodationUnitResponse(AddAccommodationUnitResponse value) {
        return new JAXBElement<AddAccommodationUnitResponse>(_AddAccommodationUnitResponse_QNAME, AddAccommodationUnitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAccommodation }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.agent.megatravel.com/", name = "addAccommodation")
    public JAXBElement<AddAccommodation> createAddAccommodation(AddAccommodation value) {
        return new JAXBElement<AddAccommodation>(_AddAccommodation_QNAME, AddAccommodation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SmestajXMLDTO }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.agent.megatravel.com/", name = "SmestajXMLDTO")
    public JAXBElement<SmestajXMLDTO> createSmestajXMLDTO(SmestajXMLDTO value) {
        return new JAXBElement<SmestajXMLDTO>(_SmestajXMLDTO_QNAME, SmestajXMLDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SOAPException }{@code >}}
     *
     */

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UslugaXMLDTO }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.agent.megatravel.com/", name = "UslugaXMLDTO")
    public JAXBElement<UslugaXMLDTO> createUslugaXMLDTO(UslugaXMLDTO value) {
        return new JAXBElement<UslugaXMLDTO>(_UslugaXMLDTO_QNAME, UslugaXMLDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccomodationTypeXMLDTO }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.agent.megatravel.com/", name = "AccomodationTypeXMLDTO")
    public JAXBElement<AccomodationTypeXMLDTO> createAccomodationTypeXMLDTO(AccomodationTypeXMLDTO value) {
        return new JAXBElement<AccomodationTypeXMLDTO>(_AccomodationTypeXMLDTO_QNAME, AccomodationTypeXMLDTO.class, null, value);
    }

    private final static QName _UserCredentialsXMLDTO_QNAME = new QName("http://service.agent.megatravel.com/", "UserCredentialsXMLDTO");
    private final static QName _FirstLogin_QNAME = new QName("http://service.agent.megatravel.com/", "firstLogin");
    private final static QName _FirstLoginResponse_QNAME = new QName("http://service.agent.megatravel.com/", "firstLoginResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FirstLoginResponse }
     * 
     */
    public FirstLoginResponse createFirstLoginResponse() {
        return new FirstLoginResponse();
    }

    /**
     * Create an instance of {@link FirstLogin }
     * 
     */
    public FirstLogin createFirstLogin() {
        return new FirstLogin();
    }

    /**
     * Create an instance of {@link SOAPException }
     * 
     */
    public SOAPException createSOAPException() {
        return new SOAPException();
    }

    /**
     * Create an instance of {@link SOAPFaultException }
     * 
     */
    public SOAPFaultException createSOAPFaultException() {
        return new SOAPFaultException();
    }

    /**
     * Create an instance of {@link UserCredentialsXMLDTO }
     * 
     */
    public UserCredentialsXMLDTO createUserCredentialsXMLDTO() {
        return new UserCredentialsXMLDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserCredentialsXMLDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.agent.megatravel.com/", name = "UserCredentialsXMLDTO")
    public JAXBElement<UserCredentialsXMLDTO> createUserCredentialsXMLDTO(UserCredentialsXMLDTO value) {
        return new JAXBElement<UserCredentialsXMLDTO>(_UserCredentialsXMLDTO_QNAME, UserCredentialsXMLDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SOAPFaultException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.agent.megatravel.com/", name = "SOAPFaultException")
    public JAXBElement<SOAPFaultException> createSOAPFaultException(SOAPFaultException value) {
        return new JAXBElement<SOAPFaultException>(_SOAPFaultException_QNAME, SOAPFaultException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SOAPException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.agent.megatravel.com/", name = "SOAPException")
    public JAXBElement<SOAPException> createSOAPException(SOAPException value) {
        return new JAXBElement<SOAPException>(_SOAPException_QNAME, SOAPException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FirstLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.agent.megatravel.com/", name = "firstLogin")
    public JAXBElement<FirstLogin> createFirstLogin(FirstLogin value) {
        return new JAXBElement<FirstLogin>(_FirstLogin_QNAME, FirstLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FirstLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.agent.megatravel.com/", name = "firstLoginResponse")
    public JAXBElement<FirstLoginResponse> createFirstLoginResponse(FirstLoginResponse value) {
        return new JAXBElement<FirstLoginResponse>(_FirstLoginResponse_QNAME, FirstLoginResponse.class, null, value);
    }

}
