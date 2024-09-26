package org.example.demo.models;

import javafx.beans.property.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Packages {
    @Id
    private SimpleIntegerProperty PackageId;
    private final SimpleStringProperty PkgName;
    private SimpleDateFormat PkgStartDate;
    private SimpleDateFormat PkgEndDate;
    private final SimpleStringProperty PkgDesc;
    private final SimpleDoubleProperty PkgBasePrice;
    private SimpleDoubleProperty PkgAgencyCommission;

    // Constructors
    public Packages() {
        this.PackageId = new SimpleIntegerProperty();
        this.PkgName = new SimpleStringProperty();
        this.PkgStartDate = new SimpleDateFormat();
        this.PkgEndDate = new SimpleDateFormat();
        this.PkgDesc = new SimpleStringProperty();
        this.PkgBasePrice = new SimpleDoubleProperty();
        this.PkgAgencyCommission = new SimpleDoubleProperty();
    }

    public Packages(
            SimpleStringProperty pkgName,
            SimpleStringProperty pkgDesc,
            SimpleDoubleProperty pkgBasePrice
           )
    {
        this.PkgName = pkgName;
        this.PkgDesc = pkgDesc;
        this.PkgBasePrice = pkgBasePrice;
    }

    // Getters and Setters
    public int getPackageId() {
        return PackageId.get();
    }

    public void setPackageId(int packageId) {
        this.PackageId.set(packageId);
    }

    public String getPkgName() {
        return PkgName.get();
    }

    public void setPkgName(String pkgName) {
        this.PkgName.set(pkgName);
    }

    public String getPkgStartDate() {
        return PkgStartDate.format(new Date());
    }

    public void setPkgStartDate(Date pkgStartDate) {
        this.PkgStartDate = new SimpleDateFormat("yyyy-MM-dd");
    }

    public String getPkgEndDate() {
        return PkgEndDate.format(new Date());
    }

    public void setPkgEndDate(Date pkgEndDate) {
        this.PkgEndDate = new SimpleDateFormat("yyyy-MM-dd");
    }

    public String getPkgDesc() {
        return PkgDesc.get();
    }

    public void setPkgDesc(String pkgDesc) {
        this.PkgDesc.set(pkgDesc);
    }

    public double getPkgBasePrice() {
        return PkgBasePrice.get();
    }

    public void setPkgBasePrice(int pkgBasePrice) {
        this.PkgBasePrice.set(pkgBasePrice);
    }

    public double getPkgAgencyCommission() {
        return PkgAgencyCommission.get();
    }

    public void setPkgAgencyCommission(int pkgAgencyCommission) {
        this.PkgAgencyCommission.set(pkgAgencyCommission);
    }

    // Methods
}
