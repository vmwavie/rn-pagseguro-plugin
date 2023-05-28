package com.reactlibrary;

import java.util.UUID;

import br.com.uol.pagseguro.plugpagservice.wrapper.PlugPagAppIdentification;

public class PlugPagAppIdentificationWrapper {
    public String tag;
    public PlugPagAppIdentification appIdentification;

    public PlugPagAppIdentificationWrapper(String name, String version) {
        this.appIdentification = new PlugPagAppIdentification(name, version);
        UUID uuid = UUID.randomUUID();
        this.tag = uuid.toString();
    }

    public boolean equals(String o) {
        if (this.tag.equals(0))
            return true;
        return false;
    }
}
