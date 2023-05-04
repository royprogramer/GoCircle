package com.teamvoid.gocircle.circlemod;

import java.sql.Blob;

public class CircleModel {
  private String circleName;
  private String getCircleId;
  private Blob circlePicBlob;
  private String username;

    public CircleModel( String getCircleId,String circleName, Blob circlePicBlob, String username) {
        this.circleName = circleName;
        this.getCircleId = getCircleId;
        this.circlePicBlob = circlePicBlob;
        this.username = username;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public String getGetCircleId() {
        return getCircleId;
    }

    public void setGetCircleId(String getCircleId) {
        this.getCircleId = getCircleId;
    }

    public Blob getCirclePicBlob() {
        return circlePicBlob;
    }

    public void setCirclePicBlob(Blob circlePicBlob) {
        this.circlePicBlob = circlePicBlob;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
