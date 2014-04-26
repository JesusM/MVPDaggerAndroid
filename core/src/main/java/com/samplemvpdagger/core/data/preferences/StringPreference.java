package com.samplemvpdagger.core.data.preferences;

@SuppressWarnings("UnusedDeclaration")
public class StringPreference {
    private final PreferencesWrapper preferences;
    private final String key;
    private final String defaultValue;

    public StringPreference(PreferencesWrapper preferences, String key) {
        this(preferences, key, null);
    }

    public StringPreference(PreferencesWrapper preferences, String key, String defaultValue) {
        this.preferences = preferences;
        this.key = key;
        this.defaultValue = defaultValue;
    }

    public String get() {
        return preferences.getString(key, defaultValue);
    }

    public boolean isSet() {
        return preferences.contains(key);
    }

    public void set(String value) {
        preferences.putString(key, value);
    }

    public void delete() {
        preferences.remove(key);
    }
}
