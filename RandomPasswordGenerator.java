import java.util.*;

public class RandomPasswordGenerator 
{
    
    public static void main(String[] args) 
{
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();
        
        
        System.out.println("Specify which character sets should be included:");
        System.out.print("Include numbers (0-9)? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");
        System.out.print("Include lowercase letters (a-z)? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");
        System.out.print("Include uppercase letters (A-Z)? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");
        System.out.print("Include special characters (!@#$%^&*()_+)? (yes/no): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("yes");
        
        
        if (!includeNumbers && !includeLowercase && !includeUppercase && !includeSpecialChars)
 {
            System.out.println("You must include at least one type of character set.");
            return;
        }
        
        
        String password = generateRandomPassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecialChars);
        
       
        System.out.println("Generated password: " + password);
        
        scanner.close();
    }
    
    public static String generateRandomPassword(int length, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean includeSpecialChars) 
{
        
        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*()_+";
        
       
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        
        
        List<String> charSets = new ArrayList<>();
        if (includeNumbers) charSets.add(numbers);
        if (includeLowercase) charSets.add(lowercase);
        if (includeUppercase) charSets.add(uppercase);
        if (includeSpecialChars) charSets.add(specialChars);
        
        
        for (int i = 0; i < length; i++)
 {
            
            String selectedSet = charSets.get(random.nextInt(charSets.size()));
            
            char randomChar = selectedSet.charAt(random.nextInt(selectedSet.length()));
            
            password.append(randomChar);
        }
        
        return password.toString();
    }
}
