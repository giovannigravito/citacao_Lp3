/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 31427782
 */
@Entity
@Table(name = "CITACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citacao.findAll", query = "SELECT c FROM Citacao c"),
    @NamedQuery(name = "Citacao.findByIdCitacao", query = "SELECT c FROM Citacao c WHERE c.idCitacao = :idCitacao"),
    @NamedQuery(name = "Citacao.findByText", query = "SELECT c FROM Citacao c WHERE c.text = :text")})
public class Citacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CITACAO")
    private Integer idCitacao;
    @Size(max = 140)
    @Column(name = "TEXT")
    private String text;
    @JoinColumn(name = "ID_AUTOR", referencedColumnName = "ID_AUTOR")
    @ManyToOne
    private Autor idAutor;

    public Citacao() {
    }

    public Citacao(Integer idCitacao) {
        this.idCitacao = idCitacao;
    }

    public Integer getIdCitacao() {
        return idCitacao;
    }

    public void setIdCitacao(Integer idCitacao) {
        this.idCitacao = idCitacao;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Autor getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Autor idAutor) {
        this.idAutor = idAutor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCitacao != null ? idCitacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citacao)) {
            return false;
        }
        Citacao other = (Citacao) object;
        if ((this.idCitacao == null && other.idCitacao != null) || (this.idCitacao != null && !this.idCitacao.equals(other.idCitacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.entities.Citacao[ idCitacao=" + idCitacao + " ]";
    }
    
}
