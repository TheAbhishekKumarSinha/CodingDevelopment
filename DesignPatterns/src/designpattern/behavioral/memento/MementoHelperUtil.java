package designpattern.behavioral.memento;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class MementoHelperUtil {

    private String fileName;
    private StringBuilder builder;

    /**
     * @param fileName
     */
    public MementoHelperUtil(String fileName) {
        super();
        this.fileName = fileName;
        builder = new StringBuilder();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void write(String content) {
        builder.append(content);
    }

    public void setBuilder(StringBuilder builder) {
        this.builder = builder;
    }

    public void undo(Object obj) {
        Momento momento = (Momento) obj;
        this.fileName = momento.fileName;
        this.builder = momento.builder;

    }

    public Momento save() {
        return new Momento(this.fileName, this.builder.toString());

    }

    private class Momento {
        private String fileName;
        private StringBuilder builder;

        /**
         * @param fileName
         * @param builder
         */
        public Momento(String fileName, String builder) {
            super();
            this.fileName = fileName;
            this.builder = new StringBuilder(builder);
        }

    }

    @Override
    public String toString() {
        return this.builder.toString();
    }

}
