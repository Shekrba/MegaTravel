package com.megatravel.agent.xml.dto;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public final class Base64Adapter extends XmlAdapter<String,byte[]> {

    @Override
    public String marshal(byte[] v) throws Exception {
        return new String(v);
    }

    @Override
    public byte[] unmarshal(String v) throws Exception {
        return v.getBytes();
    }
}
