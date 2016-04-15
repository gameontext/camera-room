package net.wasdev.gameon.cameraroom;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CameraRoomImage {
    private final String name;
    private final byte[] image;
    
    private CameraRoomImage(String name, byte[] image) {
        this.name = name;
        this.image = image;
    }
    
    public String getName() {
        return name;
    }

    public byte[] getImage() {
        return image;
    }

    public static CameraRoomImage getInstance(String name, String imgfile) {
        try(InputStream stream = CameraRoomImage.class.getResourceAsStream("/" + imgfile +".jpg")) {
            if(stream == null) {
                return new CameraRoomImage(name, new byte[]{});
            }
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int read = 0;
            byte[] buffer = new byte[1024];
            while((read = stream.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            } 
            out.close();
            return new CameraRoomImage(name, out.toByteArray());
        } catch (IOException e) {
            System.out.println("Error reading room description : " + e.getMessage());
            return new CameraRoomImage(name, new byte[]{});
        }
    }
}
