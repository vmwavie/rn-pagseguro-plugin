package com.reactlibrary;

import android.content.Context;

import java.util.UUID;

import br.com.uol.pagseguro.plugpagservice.wrapper.PlugPag;
import br.com.uol.pagseguro.plugpagservice.wrapper.PlugPagAppIdentification;

public class PlugPagWrapper {
    public PlugPag plugPag;
    public String tag;

    public PlugPagWrapper(Context context, PlugPagAppIdentification appIdentification) {
        plugPag = new PlugPag(context, appIdentification);
        UUID uuid = UUID.randomUUID();
        this.tag = uuid.toString();
    }

    public boolean equals(String o) {
        if (this.tag.equals(o))
            return true;
        return false;
    }
}
