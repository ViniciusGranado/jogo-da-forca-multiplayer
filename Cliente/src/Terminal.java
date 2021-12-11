public class Terminal {
  public static void clear() {
    if (System.getProperty("os.name").contains("Windows"))
      try {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } catch (Exception erro) {}
    else
      try {
        Runtime.getRuntime().exec("clear");
      } catch (Exception erro) {}
  }
}
