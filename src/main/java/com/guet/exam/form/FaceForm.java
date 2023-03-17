package com.guet.exam.form;

public class FaceForm {
    private String image;
    private String faceVector;

    public String getFaceVector() {
        return faceVector;
    }

    public void setFaceVector(String faceVector) {
        this.faceVector = faceVector;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "FaceForm{" +
                "image='" + image + '\'' +
                ", faceVector='" + faceVector + '\'' +
                '}';
    }
}
