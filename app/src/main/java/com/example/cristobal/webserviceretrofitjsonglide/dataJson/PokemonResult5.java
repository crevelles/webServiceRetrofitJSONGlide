package com.example.cristobal.webserviceretrofitjsonglide.dataJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by cristobal on 07/02/2018.
 */

public class PokemonResult5 {
    public class VersionGroup {

        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("name")
        @Expose
        private String name;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
