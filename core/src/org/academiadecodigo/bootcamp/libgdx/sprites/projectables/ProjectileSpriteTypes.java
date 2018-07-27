package org.academiadecodigo.bootcamp.libgdx.sprites.projectables;

import org.academiadecodigo.bootcamp.simulation.projectables.ProjectableType;

public enum ProjectileSpriteTypes {

    BULLET(ProjectableType.BULLET, "atomicBullet.png");

    private ProjectableType projectableType;
    private String textureFile;

    ProjectileSpriteTypes(ProjectableType projectableType, String textureFile) {
        this.projectableType = projectableType;
        this.textureFile = textureFile;
    }

    public static ProjectileSpriteTypes get(ProjectableType projectableType) {

        for(ProjectileSpriteTypes type : values()) {
            if(type.projectableType == projectableType) {
                return type;
            }
        }

        return null;
    }

    public String getTextureFile() {
        return textureFile;
    }

}
