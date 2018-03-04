package com.example.cristobal.webserviceretrofitjsonglide.dataJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by cristobal on 07/02/2018.
 */

public class PokemonResult4 {
    public class Sprites {

        @SerializedName("front_default")
        @Expose
        private String frontDefault;
        @SerializedName("back_default")
        @Expose
        private String backDefault;
        @SerializedName("front_shiny")
        @Expose
        private String frontShiny;
        @SerializedName("back_shiny")
        @Expose
        private String backShiny;

        public String getFrontDefault() {
            return frontDefault;
        }

        public void setFrontDefault(String frontDefault) {
            this.frontDefault = frontDefault;
        }

        public String getBackDefault() {
            return backDefault;
        }

        public void setBackDefault(String backDefault) {
            this.backDefault = backDefault;
        }

        public String getFrontShiny() {
            return frontShiny;
        }

        public void setFrontShiny(String frontShiny) {
            this.frontShiny = frontShiny;
        }

        public String getBackShiny() {
            return backShiny;
        }

        public void setBackShiny(String backShiny) {
            this.backShiny = backShiny;
        }

    }
}
