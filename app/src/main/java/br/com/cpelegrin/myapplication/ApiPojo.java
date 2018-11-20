
package br.com.cpelegrin.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiPojo {

    @SerializedName("by")
    @Expose
    private String by;
    @SerializedName("valid_key")
    @Expose
    private boolean validKey;
    @SerializedName("results")
    @Expose
    private Results results;
    @SerializedName("execution_time")
    @Expose
    private float executionTime;
    @SerializedName("from_cache")
    @Expose
    private boolean fromCache;

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public boolean isValidKey() {
        return validKey;
    }

    public void setValidKey(boolean validKey) {
        this.validKey = validKey;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public float getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(float executionTime) {
        this.executionTime = executionTime;
    }

    public boolean isFromCache() {
        return fromCache;
    }

    public void setFromCache(boolean fromCache) {
        this.fromCache = fromCache;
    }

}
