package com.java.se7.pattern.recipes.builder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vf-root on 1/26/15.
 */
public class RequestEvent {

    private static final String EVENT_TYPE = "even-type";
    private static final String X_VF_TRACE_TRANSACTION_ID = "x-vf-trace-transaction-id";
    private static final String X_VF_TRACE_SUBJECT_ID = "x-vf-trace-subject-id";
    private static final String X_VF_TRACE_SUBJECT_REGION = "x-vf-trace-subject-region";
    private static final String X_VF_TRACE_TIMESTAMP = "x-vf-trace-timestamp";
    private static final String X_VF_TRACE_COMPONENT = "x-vf-trace-component";
    private static final String X_VF_TRACE_COMPONENT_VERSION = "x-vf-trace-component-version";
    private static final String X_VF_TRACE_SOURCE = "x-vf-trace-source";
    private static final String X_VF_TRACE_SOURCE_VERSION = "x-vf-trace-source-version";
    private static final String X_VF_TRACE_DESTINATION = "x-vf-trace-destination";
    private static final String REQUEST_PROTOCOL = "request-protocol";
    private static final String REQUEST_URL = "request-url";
    private static final String REQUEST_URL_PATH = "request-url-path";
    private static final String REQUEST_URL_QS = "request-url-qs";
    private static final String REQUEST_URL_QS_DEVICE_FAMILY = "request-url-qs.device-family";
    private static final String REQUEST_METHOD = "request-method";
    private static final String REQUEST_HEADER_HOST = "request-header.Host";
    private static final String REQUEST_HEADER_AUTHORIZATION = "request-header.Authorization";
    private static final String REQUEST_HEADER_ACCEPT = "request-header.Accept";
    private static final String REQUEST_HEADER_ACCEPT_LANGUAGE = "request-header.Accept-Language";
    private static final String REQUEST_HEADER_X_VF_TRACE_TRANSACTION_ID = "request-header.x-vf-trace-transaction-id";
    private static final String REQUEST_HEADER_X_VF_TRACE_SUBJECT_ID = "request-header.x-vf-trace-subject-id";
    private static final String REQUEST_HEADER_X_VF_TRACE_COMPONENT = "request-header.x-vf-trace-component";
    private static final String REQUEST_HEADER_X_VF_TRACE_COMPONENT_VERSION = "request-header.x-vf-trace-component-version";
    private static final String REQUEST_HEADER_X_VF_TRACE_DESTINATION = "request-header.x-vf-trace-destination";
    private static final String ROUND_TRIP_TIME = "round-trip-time";
    private static final String RESPONSE_CODE = "response-code";
    private static final String RESPONSE_HEADER_DATE = "response-header.Date";
    private static final String RESPONSE_HEADER_LAST_MODIFIED = "response-header.Last-Modified";
    private static final String RESPONSE_HEADER_EXPIRES = "response-header.Expires";
    private static final String RESPONSE_HEADER_CACHE_CONTROL = "response-header.Cache-Control";
    private static final String RESPONSE_HEADER_CONTENT_TYPE = "response-header.Content-Type";
    private static final String RESPONSE_HEADER_X_VF_TRACE_TRANSACTION_ID = "response-header.x-vf-trace-transaction-id";
    private static final String RESPONSE_HEADER_X_VF_TRACE_COMPONENT = "response-header.x-vf-trace-component";
    private static final String RESPONSE_HEADER_X_VF_TRACE_COMPONENT_VERSION = "response-header.x-vf-trace-component-version";
    private static final String RESPONSE_BODY = "response.body";

    private Map<String, String> eventDetail = new HashMap<String, String>();

    public RequestEvent() {

    }

    private RequestEvent(String eventType, String transactionId, String subjectId, String subjectRegion, String timestamp, String component,
        String componentVersion, String source, String sourceVersion, String requestProtocol, String requestUrl, String requestUrlPath,
        String requestQueryString, String requestDeviceFamily, String requestMethod, String requestHeaderHost, String requestHeaderAuth,
        String requestHeaderAccept, String requestHeaderAcceptLanguage, String requestHeaderTransactionId, String requestHeaderSubjectId,
        String requestHeaderComponent, String requestHeaderComponentVersion, String requestHeaderDestination, String roundTripTime,
        String responseCode, String responseHeaderDate, String responseHeaderLastModified, String responseHeaderExpires,
        String responseHeaderCacheControl, String responseHeaderContentType, String responseHeaderTransactionId,
        String responseHeaderComponent, String responseHeaderComponentVersion, String responseBody) {
        this.eventDetail.put(EVENT_TYPE, eventType);
        this.eventDetail.put(X_VF_TRACE_TRANSACTION_ID, transactionId);
        this.eventDetail.put(X_VF_TRACE_SUBJECT_ID, subjectId);
        this.eventDetail.put(X_VF_TRACE_SUBJECT_REGION, subjectRegion);
        this.eventDetail.put(X_VF_TRACE_TIMESTAMP, timestamp);
        this.eventDetail.put(X_VF_TRACE_COMPONENT, component);
        this.eventDetail.put(X_VF_TRACE_COMPONENT_VERSION, componentVersion);
        this.eventDetail.put(X_VF_TRACE_SOURCE, source);
        this.eventDetail.put(X_VF_TRACE_SOURCE_VERSION, sourceVersion);
        this.eventDetail.put(REQUEST_PROTOCOL, requestProtocol);
        this.eventDetail.put(REQUEST_URL, requestUrl);
        this.eventDetail.put(REQUEST_URL_PATH, requestUrlPath);
        this.eventDetail.put(REQUEST_URL_QS, requestQueryString);
        this.eventDetail.put(REQUEST_URL_QS_DEVICE_FAMILY, requestDeviceFamily);
        this.eventDetail.put(REQUEST_METHOD, requestMethod);
        this.eventDetail.put(REQUEST_HEADER_HOST, requestHeaderHost);
        this.eventDetail.put(REQUEST_HEADER_AUTHORIZATION, requestHeaderAuth);
        this.eventDetail.put(REQUEST_HEADER_ACCEPT, requestHeaderAccept);
        this.eventDetail.put(REQUEST_HEADER_ACCEPT_LANGUAGE, requestHeaderAcceptLanguage);
        this.eventDetail.put(REQUEST_HEADER_X_VF_TRACE_TRANSACTION_ID, requestHeaderTransactionId);
        this.eventDetail.put(REQUEST_HEADER_X_VF_TRACE_SUBJECT_ID, requestHeaderSubjectId);
        this.eventDetail.put(REQUEST_HEADER_X_VF_TRACE_COMPONENT, requestHeaderComponent);
        this.eventDetail.put(REQUEST_HEADER_X_VF_TRACE_COMPONENT_VERSION, requestHeaderComponentVersion);
        this.eventDetail.put(REQUEST_HEADER_X_VF_TRACE_DESTINATION, requestHeaderDestination);
        this.eventDetail.put(ROUND_TRIP_TIME, roundTripTime);
        this.eventDetail.put(RESPONSE_CODE, responseCode);
        this.eventDetail.put(RESPONSE_HEADER_DATE, responseHeaderDate);
        this.eventDetail.put(RESPONSE_HEADER_LAST_MODIFIED, responseHeaderLastModified);
        this.eventDetail.put(RESPONSE_HEADER_EXPIRES, responseHeaderExpires);
        this.eventDetail.put(RESPONSE_HEADER_CACHE_CONTROL, responseHeaderCacheControl);
        this.eventDetail.put(RESPONSE_HEADER_CONTENT_TYPE, responseHeaderContentType);
        this.eventDetail.put(RESPONSE_HEADER_X_VF_TRACE_TRANSACTION_ID, responseHeaderTransactionId);
        this.eventDetail.put(RESPONSE_HEADER_X_VF_TRACE_COMPONENT, responseHeaderComponent);
        this.eventDetail.put(RESPONSE_HEADER_X_VF_TRACE_COMPONENT_VERSION, responseHeaderComponentVersion);
        this.eventDetail.put(RESPONSE_BODY, responseBody);
    }

    public String getEventType() {
        return this.eventDetail.get(EVENT_TYPE);
    }

    public String getTransactionId() {
        return this.eventDetail.get(X_VF_TRACE_TRANSACTION_ID);
    }

    public String getSubjectId() {
        return this.eventDetail.get(X_VF_TRACE_SUBJECT_ID);
    }

    public String getSubjectRegion() {
        return this.eventDetail.get(X_VF_TRACE_SUBJECT_REGION);
    }

    public String getTimestamp() {
        return this.eventDetail.get(X_VF_TRACE_TIMESTAMP);
    }

    public String getComponent() {
        return this.eventDetail.get(X_VF_TRACE_COMPONENT);
    }

    public String getComponentVersion() {
        return this.eventDetail.get(X_VF_TRACE_COMPONENT_VERSION);
    }

    public String getSource() {
        return this.eventDetail.get(X_VF_TRACE_SOURCE);
    }

    public String getSourceVersion() {
        return this.eventDetail.get(X_VF_TRACE_SOURCE_VERSION);
    }

    public String getRequestProtocol() {
        return this.eventDetail.get(REQUEST_PROTOCOL);
    }

    public String getRequestUrl() {
        return this.eventDetail.get(REQUEST_URL);
    }

    public String getRequestUrlPath() {
        return this.eventDetail.get(REQUEST_URL_PATH);
    }

    public String getRequestQueryString() {
        return this.eventDetail.get(REQUEST_URL_QS);
    }

    public String getRequestDeviceFamily() {
        return this.eventDetail.get(REQUEST_URL_QS_DEVICE_FAMILY);
    }

    public String getRequestMethod() {
        return this.eventDetail.get(REQUEST_METHOD);
    }

    public String getRequestHeaderHost() {
        return this.eventDetail.get(REQUEST_HEADER_HOST);
    }

    public String getRequestHeaderAuthorization() {
        return this.eventDetail.get(REQUEST_HEADER_AUTHORIZATION);
    }

    public String getRequestHeaderAccept() {
        return this.eventDetail.get(REQUEST_HEADER_ACCEPT);
    }

    public String getRequestHeaderAcceptLanguage() {
        return this.eventDetail.get(REQUEST_HEADER_ACCEPT_LANGUAGE);
    }

    public String getRequestHeaderTransactionId() {
        return this.eventDetail.get(REQUEST_HEADER_X_VF_TRACE_TRANSACTION_ID);
    }

    public String getRequestHeaderSubjectId() {
        return this.eventDetail.get(REQUEST_HEADER_X_VF_TRACE_SUBJECT_ID);
    }

    public String getRequestHeaderComponent() {
        return this.eventDetail.get(REQUEST_HEADER_X_VF_TRACE_COMPONENT);
    }

    public String getRequestHeaderComponentVersion() {
        return this.eventDetail.get(REQUEST_HEADER_X_VF_TRACE_COMPONENT_VERSION);
    }

    public String getRequestHeaderDestination() {
        return this.eventDetail.get(REQUEST_HEADER_X_VF_TRACE_DESTINATION);
    }

    public String getRoundTripTime() {
        return this.eventDetail.get(ROUND_TRIP_TIME);
    }

    public String getResponseCode() {
        return this.eventDetail.get(RESPONSE_CODE);
    }

    public String getResponseHeaderDate() {
        return this.eventDetail.get(RESPONSE_HEADER_DATE);
    }

    public String getResponseHeaderLastModified() {
        return this.eventDetail.get(RESPONSE_HEADER_LAST_MODIFIED);
    }

    public String getResponseHeaderExpires() {
        return this.eventDetail.get(RESPONSE_HEADER_EXPIRES);
    }

    public String getResponseHeaderCacheControl() {
        return this.eventDetail.get(RESPONSE_HEADER_CACHE_CONTROL);
    }

    public String getResponseHeaderContentType() {
        return this.eventDetail.get(RESPONSE_HEADER_CONTENT_TYPE);
    }

    public String getResponseHeaderTransactionId() {
        return this.eventDetail.get(RESPONSE_HEADER_X_VF_TRACE_TRANSACTION_ID);
    }

    public String getResponseHeaderComponent() {
        return this.eventDetail.get(RESPONSE_HEADER_X_VF_TRACE_COMPONENT);
    }

    public String getResponseHeaderComponentVersion() {
        return this.eventDetail.get(RESPONSE_HEADER_X_VF_TRACE_COMPONENT_VERSION);
    }

    public String getResponseBody() {
        return this.eventDetail.get(RESPONSE_BODY);
    }

    public Map<String, String> get() {
        return eventDetail;
    }

    public static class RequestEventBuilder {
        private RequestEvent event;
        private Map<String, String> eventDetail = new HashMap<String, String>();

        public RequestEventBuilder(){

        }

        public RequestEventBuilder(RequestEvent event){
            this.event = event;
        }

        public RequestEventBuilder eventType(String eventType) {
            this.setValue(EVENT_TYPE, eventType);
            return this;
        }

        public RequestEventBuilder transactionId(String transactionId) {
            this.setValue(X_VF_TRACE_TRANSACTION_ID, transactionId);
            return this;
        }

        public RequestEventBuilder subjectId(String subjectId) {
            this.setValue(X_VF_TRACE_SUBJECT_ID, subjectId);
            return this;
        }

        public RequestEventBuilder subjectRegion(String subjectRegion) {
            this.setValue(X_VF_TRACE_SUBJECT_REGION, subjectRegion);
            return this;
        }

        public RequestEventBuilder timestamp(String timestamp) {
            this.setValue(X_VF_TRACE_TIMESTAMP, timestamp);
            return this;
        }

        public RequestEventBuilder component(String component) {
            this.setValue(X_VF_TRACE_COMPONENT, component);
            return this;
        }

        public RequestEventBuilder componentVersion(String componentVersion) {
            this.setValue(X_VF_TRACE_COMPONENT_VERSION, componentVersion);
            return this;
        }

        public RequestEventBuilder source(String source) {
            this.setValue(X_VF_TRACE_SOURCE, source);
            return this;
        }

        public RequestEventBuilder sourceVersion(String sourceVersion) {
            this.setValue(X_VF_TRACE_SOURCE_VERSION, sourceVersion);
            return this;
        }

        public RequestEventBuilder requestProtocol(String requestProtocol) {
            this.setValue(REQUEST_PROTOCOL, requestProtocol);
            return this;
        }

        public RequestEventBuilder requestUrl(String requestUrl) {
            this.setValue(REQUEST_URL, requestUrl);
            return this;
        }

        public RequestEventBuilder requestUrlPath(String requestUrlPath) {
            this.setValue(REQUEST_URL_PATH, requestUrlPath);
            return this;
        }

        public RequestEventBuilder requestQueryString(String requestQueryString) {
            this.setValue(REQUEST_URL_QS, requestQueryString);
            return this;
        }

        public RequestEventBuilder requestDeviceFamily(String requestDeviceFamily) {
            this.setValue(REQUEST_URL_QS_DEVICE_FAMILY, requestDeviceFamily);
            return this;
        }

        public RequestEventBuilder requestMethod(String requestMethod) {
            this.setValue(REQUEST_METHOD, requestMethod);
            return this;
        }

        public RequestEventBuilder requestHeaderHost(String requestHeaderHost) {
            this.setValue(REQUEST_HEADER_HOST, requestHeaderHost);
            return this;
        }

        public RequestEventBuilder requestHeaderAuthorization(String requestHeaderAuth) {
            this.setValue(REQUEST_HEADER_AUTHORIZATION, requestHeaderAuth);
            return this;
        }

        public RequestEventBuilder requestHeaderAccept(String requestHeaderAccept) {
            this.setValue(REQUEST_HEADER_ACCEPT, requestHeaderAccept);
            return this;
        }

        public RequestEventBuilder requestHeaderAcceptLanguage(String requestHeaderAcceptLanguage) {
            this.setValue(REQUEST_HEADER_ACCEPT_LANGUAGE, requestHeaderAcceptLanguage);
            return this;
        }

        public RequestEventBuilder requestHeaderTransactionId(String requestHeaderTransactionId) {
            this.setValue(REQUEST_HEADER_X_VF_TRACE_TRANSACTION_ID, requestHeaderTransactionId);
            return this;
        }

        public RequestEventBuilder setRequestHeaderSubjectId(String requestHeaderSubjectId) {
            this.setValue(REQUEST_HEADER_X_VF_TRACE_SUBJECT_ID, requestHeaderSubjectId);
            return this;
        }

        public RequestEventBuilder requestHeaderComponent(String requestHeaderComponent) {
            this.setValue(REQUEST_HEADER_X_VF_TRACE_COMPONENT, requestHeaderComponent);
            return this;
        }

        public RequestEventBuilder requestHeaderComponentVersion(String requestHeaderComponentVersion) {
            this.setValue(REQUEST_HEADER_X_VF_TRACE_COMPONENT_VERSION, requestHeaderComponentVersion);
            return this;
        }

        public RequestEventBuilder requestHeaderDestination(String requestHeaderDestination) {
            this.setValue(REQUEST_HEADER_X_VF_TRACE_DESTINATION, requestHeaderDestination);
            return this;
        }

        public RequestEventBuilder roundTripTime(String roundTripTime) {
            this.setValue(ROUND_TRIP_TIME, roundTripTime);
            return this;
        }

        public RequestEventBuilder responseCode(String responseCode) {
            this.setValue(RESPONSE_CODE, responseCode);
            return this;
        }

        public RequestEventBuilder responseHeaderDate(String responseHeaderDate) {
            this.setValue(RESPONSE_HEADER_DATE, responseHeaderDate);
            return this;
        }

        public RequestEventBuilder responseHeaderLastModified(String responseHeaderLastModified) {
            this.setValue(RESPONSE_HEADER_LAST_MODIFIED, responseHeaderLastModified);
            return this;
        }

        public RequestEventBuilder responseHeaderExpires(String responseHeaderExpires) {
            this.eventDetail.put(RESPONSE_HEADER_EXPIRES, responseHeaderExpires);
            return this;
        }

        public RequestEventBuilder responseHeaderCacheControl(String responseHeaderCacheControl) {
            this.setValue(RESPONSE_HEADER_CACHE_CONTROL, responseHeaderCacheControl);
            return this;
        }

        public RequestEventBuilder responseHeaderContentType(String responseHeaderContentType) {
            this.setValue(RESPONSE_HEADER_CONTENT_TYPE, responseHeaderContentType);
            return this;
        }

        public RequestEventBuilder responseHeaderTransactionId(String responseHeaderTransactionId) {
            this.setValue(RESPONSE_HEADER_X_VF_TRACE_TRANSACTION_ID, responseHeaderTransactionId);
            return this;
        }

        public RequestEventBuilder responseHeaderComponent(String responseHeaderComponent) {
            this.setValue(RESPONSE_HEADER_X_VF_TRACE_COMPONENT, responseHeaderComponent);
            return this;
        }

        public RequestEventBuilder responseHeaderComponentVersion(String responseHeaderComponentVersion) {
            this.setValue(RESPONSE_HEADER_X_VF_TRACE_COMPONENT_VERSION, responseHeaderComponentVersion);
            return this;
        }

        public RequestEventBuilder responseBody(String responseBody) {
            this.setValue(RESPONSE_BODY, responseBody);
            return this;
        }

        private String getValue(String key){
            return this.eventDetail.get(key) != null ? eventDetail.get(key) : "";
        }

        private void setValue(String key, String value){
            if (value != null && !value.isEmpty()){
                if (this.event != null){
                    this.event.get().put(key, value);
                }else{
                    this.eventDetail.put(key, value);
                }
            }
        }


        public RequestEvent build() {
            if (this.event == null){
                return new RequestEvent(this.getValue(EVENT_TYPE), this.getValue(X_VF_TRACE_TRANSACTION_ID),
                    this.getValue(X_VF_TRACE_SUBJECT_ID), this.getValue(X_VF_TRACE_SUBJECT_REGION),
                    this.getValue(X_VF_TRACE_TIMESTAMP), this.getValue(X_VF_TRACE_COMPONENT),
                    this.getValue(X_VF_TRACE_COMPONENT_VERSION), this.getValue(X_VF_TRACE_SOURCE),
                    this.getValue(X_VF_TRACE_SOURCE_VERSION), this.getValue(REQUEST_PROTOCOL), this.getValue(REQUEST_URL),
                    this.getValue(REQUEST_URL_PATH), this.getValue(REQUEST_URL_QS), this.getValue(REQUEST_URL_QS_DEVICE_FAMILY),
                    this.getValue(REQUEST_METHOD), this.getValue(REQUEST_HEADER_HOST), this.getValue(REQUEST_HEADER_AUTHORIZATION),
                    this.getValue(REQUEST_HEADER_ACCEPT),
                    this.getValue(REQUEST_HEADER_ACCEPT_LANGUAGE), this.getValue(REQUEST_HEADER_X_VF_TRACE_TRANSACTION_ID),
                    this.getValue(REQUEST_HEADER_X_VF_TRACE_SUBJECT_ID), this.getValue(REQUEST_HEADER_X_VF_TRACE_COMPONENT),
                    this.getValue(REQUEST_HEADER_X_VF_TRACE_COMPONENT_VERSION), this.getValue(REQUEST_HEADER_X_VF_TRACE_DESTINATION),
                    this.getValue(ROUND_TRIP_TIME), this.getValue(RESPONSE_CODE), this.getValue(RESPONSE_HEADER_DATE),
                    this.getValue(RESPONSE_HEADER_LAST_MODIFIED), this.getValue(RESPONSE_HEADER_EXPIRES),
                    this.getValue(RESPONSE_HEADER_CACHE_CONTROL), this.getValue(RESPONSE_HEADER_CONTENT_TYPE),
                    this.getValue(RESPONSE_HEADER_X_VF_TRACE_TRANSACTION_ID), this.getValue(RESPONSE_HEADER_X_VF_TRACE_COMPONENT),
                    this.getValue(RESPONSE_HEADER_X_VF_TRACE_COMPONENT_VERSION), this.getValue(RESPONSE_BODY));
            } else{
                return this.event;
            }
        }

    }

}
