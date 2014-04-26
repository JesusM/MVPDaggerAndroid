package com.jesusm.simplemvpdagger.app;


final class Modules {
    private Modules() {
        // No instances.
    }

    static Object[] list(MVPDaggerApp MVPDaggerApp) {
        return new Object[]{
                new MVPDaggerModule(MVPDaggerApp),
        };
    }
}