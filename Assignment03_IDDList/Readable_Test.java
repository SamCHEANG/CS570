//    myTest
    private final int distance = 20; // distance between operation-output and IDLList details
    private final String titleSeparator = "| "; // which separator between HEAD TAIL SIZE
    private final String listSeparator = "-"; // which separator between HEAD-TAIL-SIZE table and List
    private final int listSepAmount = 80; // how many listSeparator
    private final int HEADWidth = 20; // how wide is Title HEAD
    private final int TAILWidth = 20; // how wide is Title TAIL
    private final int SIZEWidth = 20; // how wide is Title SIZE

    private String formatGenerator(int[] arr) {
        if (arr == null || arr.length == 0) {
            return "%s";
        } StringBuilder str = new StringBuilder(); for (int i = 0; i < arr.length; i++) {
            str.append("%"); if (arr[i] != 0) {
                str.append(arr[i]);
            } str.append("s");
        } return str.toString();
    }

    private String formatGenerator(int[] arr, String sep, boolean newLine) {
        if (arr == null || arr.length == 0) {
            return "%s";
        } sep = sep == null ? "" : sep; StringBuilder str = new StringBuilder(); for (int i = 0; i < arr.length; i++) {
            str.append("%"); if (arr[i] != 0) {
                str.append(arr[i]);
            } str.append("s").append(sep);
        } if (newLine) {
            str.append("%n");
        } return str.toString();
    }

    private String separatorGenerator(String sep, int amount) {
        if (sep == null) {
            return "";
        } return String.join("", Collections.nCopies(amount, sep));
    }

    private void printDetails(){System.out.printf(formatGenerator(new int[]{-distance}), "printDetails(): ");printDetails(this);}
    private void printDetails(IDLList<E> sample) {
        String titleFormat = formatGenerator(new int[]{-HEADWidth, -TAILWidth, -SIZEWidth}, titleSeparator, true);
        String cellFormat = formatGenerator(new int[]{-distance, -(HEADWidth + titleSeparator.length()), -(TAILWidth + titleSeparator.length()), -(SIZEWidth + titleSeparator.length())}, "", true);
        String sepFormat = formatGenerator(new int[]{-distance, 0}, "", true);
        String sampleFormat = formatGenerator(new int[]{-distance, 0}, "", true); String sep = separatorGenerator(listSeparator, listSepAmount);

        E headData = head==null?null:head.data;
        E tailData = tail==null?null:tail.data;
        
        System.out.printf(titleFormat, "HEAD", "TAIL", "SIZE"); System.out.printf(cellFormat, "", headData,tailData, indices.size());
        System.out.printf(sepFormat, "", sep); System.out.printf(sampleFormat, "", sample); System.out.println("");
    }

    private void addPrint(int index, E elem) {System.out.printf(formatGenerator(new int[]{-distance}), "add(" + index + ", " + elem + "): " + add(index, elem)); printDetails(this);}

    private void addPrint(E elem) {System.out.printf(formatGenerator(new int[]{-distance}), "add(" + elem + "): " + add(elem)); printDetails(this);}

    private void appendPrint(E elem) {System.out.printf(formatGenerator(new int[]{-distance}), "append(" + elem + "): " + append(elem)); printDetails(this);}

    private void getPrint(int index) {System.out.printf(formatGenerator(new int[]{-distance}), "get(" + index + "): " + get(index)); printDetails(this);}

    private void getHeadPrint() {System.out.printf(formatGenerator(new int[]{-distance}), "getHead(): " + getHead()); printDetails(this);}

    private void getLastPrint() {System.out.printf(formatGenerator(new int[]{-distance}), "getLast(): " + getLast()); printDetails(this);}

    private void sizePrint() {System.out.printf(formatGenerator(new int[]{-distance}), "size(): " + size()); printDetails(this);}

    private void removePrint() {System.out.printf(formatGenerator(new int[]{-distance}), "remove(): " + remove()); printDetails(this);}

    private void removeLastPrint() {System.out.printf(formatGenerator(new int[]{-distance}), "removeLast(): " + removeLast()); printDetails(this);}

    private void removeAtPrint(int index) {System.out.printf(formatGenerator(new int[]{-distance}), "removeAt(" + index + "): " + removeAt(index)); printDetails(this);}

    private void removePrint(E elem) {System.out.printf(formatGenerator(new int[]{-distance}), "remove(" + elem + "): " + remove(elem)); printDetails(this);}

    public static void main(String[] args) {
        IDLList<Integer> test = new IDLList<>();
        test.printDetails();
//        add
        test.addPrint(1);
        test.addPrint(1, 2);
        test.appendPrint(3);
        test.appendPrint(4);

        test.addPrint(5,5);

//        get
        test.getPrint(0);
        test.getHeadPrint();
        test.getLastPrint();
        test.sizePrint();

        test.getPrint(-1);
        test.getPrint(5);

//        remove
        test.removePrint();
        test.removeLastPrint();
        test.removeAtPrint(0);
        test.removePrint(3);

        test.removePrint();
        test.removeLastPrint();
        test.removeAtPrint(5);
        test.appendPrint(1);test.removePrint(5);
    }
