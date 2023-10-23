package com.notify.utils.xsms;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class MdnBean {

    @JacksonXmlProperty(localName = "Subject")
    ArrayList<String> MSISDN;

//    public ArrayList<String> getMSISDN() {
//        return MSISDN;
//    }
//
//    public void setMSISDN(ArrayList<String> msisdn) {
//        MSISDN = msisdn;
//    }
}
