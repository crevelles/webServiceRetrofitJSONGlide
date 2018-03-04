package com.example.cristobal.webserviceretrofitjsonglide.dataJson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cristobal on 07/02/2018.
 */

public class PokemonResult2 {
    @SerializedName("is_battle_only")
    @Expose
    private Boolean isBattleOnly;
    @SerializedName("sprites")
    @Expose
    private PokemonResult4.Sprites sprites;
    @SerializedName("version_group")
    @Expose
    private PokemonResult5.VersionGroup versionGroup;
    @SerializedName("form_order")
    @Expose
    private Integer formOrder;
    @SerializedName("is_mega")
    @Expose
    private Boolean isMega;
    @SerializedName("form_names")
    @Expose
    private List<Object> formNames = null;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("is_default")
    @Expose
    private Boolean isDefault;
    @SerializedName("names")
    @Expose
    private List<Object> names = null;
    @SerializedName("form_name")
    @Expose
    private String formName;
    @SerializedName("pokemon")
    @Expose
    private Pokemon pokemon;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("name")
    @Expose
    private String name;

    public Boolean getIsBattleOnly() {
        return isBattleOnly;
    }

    public void setIsBattleOnly(Boolean isBattleOnly) {
        this.isBattleOnly = isBattleOnly;
    }

    public PokemonResult4.Sprites getSprites() {
        return sprites;
    }

    public void setSprites(PokemonResult4.Sprites sprites) {
        this.sprites = sprites;
    }

    public PokemonResult5.VersionGroup getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(PokemonResult5.VersionGroup versionGroup) {
        this.versionGroup = versionGroup;
    }

    public Integer getFormOrder() {
        return formOrder;
    }

    public void setFormOrder(Integer formOrder) {
        this.formOrder = formOrder;
    }

    public Boolean getIsMega() {
        return isMega;
    }

    public void setIsMega(Boolean isMega) {
        this.isMega = isMega;
    }

    public List<Object> getFormNames() {
        return formNames;
    }

    public void setFormNames(List<Object> formNames) {
        this.formNames = formNames;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public List<Object> getNames() {
        return names;
    }

    public void setNames(List<Object> names) {
        this.names = names;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

