public class ImageKey {
    private final String fileName;

    public ImageKey(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return fileName;
    }

    @Override
    public int hashCode() {
        return fileName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ImageKey other)) return false;
        return fileName.equals(other.fileName);
    }
}
