
package com.etl.youtubeapiimplement.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class VedioResponse {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("response")
    @Expose
    private Response response;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

}
