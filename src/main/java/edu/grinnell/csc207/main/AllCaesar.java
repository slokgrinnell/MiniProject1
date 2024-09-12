package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.CipherUtils;

/**
 * Main class for running Caesar Cipher encoding/decoding.
 * Prints all possible shifts of a given string.
 *
 * Author: Slok Rajbhandari
 */
public class AllCaesar {

  /**
   * Main method to execute the Caesar Cipher for all shifts.
   *
   * @param args command-line arguments, expects two parameters
   */
  public static void main(String[] args) {
    if (args.length != 2) {
      System.err.println("Error: Incorrect number of parameters.");
      return;
    } //if (args) Input Validation

    String option = args[0];
    String text = args[1];

    if (!option.equals("encode") && !option.equals("decode")) {
      System.err.println("Error: Invalid option: \"" + option + "\"."
                         + "Valid options are \"encode\" or \"decode\".");
      return;
    } //if(option) Encode or Decode

    // Caesar Cipher output for all shifts
    for (char key = 'a'; key <= 'z'; key++) {
      String result;
      if (text.isEmpty()) {
        result = "";
      } else if (!text.matches("[a-z]+")) {
        System.err.println("Error: String contains characters other than lowercase letters.");
        return;
      } else {
        result = option.equals("encode")
                ? CipherUtils.caesarEncrypt(text, key)
                : CipherUtils.caesarDecrypt(text, key);
      } // if else loop end
      System.out.println("n = " + key + ": " + result);
    } //for(key) Key to choose Encrypt or Decrypt
  } // End main(String[])
} // End AllCaesar
