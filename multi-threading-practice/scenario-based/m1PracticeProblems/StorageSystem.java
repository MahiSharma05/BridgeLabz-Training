package practice;

import java.util.*;

class FileVersion {
    String version;
    int size;

    FileVersion(String version, int size) {
        this.version = version;
        this.size = size;
    }
}

public class StorageSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, List<FileVersion>> storage = new HashMap<>();
        Map<String, String> latest = new HashMap<>();

        for (int i = 0; i < n; i++) {

            String input = sc.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];

            if (command.equals("UPLOAD")) {

                String file = parts[1];
                String version = parts[2];
                int size = Integer.parseInt(parts[3]);

                storage.putIfAbsent(file, new ArrayList<>());

                boolean exists = false;

                for (FileVersion fv : storage.get(file)) {
                    if (fv.version.equals(version)) {
                        exists = true;
                        break;
                    }
                }

                if (!exists) {
                    storage.get(file).add(new FileVersion(version, size));
                    latest.put(file, version);
                }
            }

            else if (command.equals("FETCH")) {

                String file = parts[1];

                if (!storage.containsKey(file)) {
                    System.out.println("File Not Found");
                    continue;
                }

                List<FileVersion> versions = storage.get(file);

                versions.sort((a, b) -> {
                    if (a.size != b.size)
                        return a.size - b.size;
                    return a.version.compareTo(b.version);
                });

                for (FileVersion v : versions) {
                    System.out.println(file + " " + v.version + " " + v.size);
                }
            }

            else if (command.equals("LATEST")) {

                String file = parts[1];

                if (!storage.containsKey(file)) {
                    System.out.println("File Not Found");
                    continue;
                }

                String latestVersion = latest.get(file);

                for (FileVersion v : storage.get(file)) {
                    if (v.version.equals(latestVersion)) {
                        System.out.println(file + " " + v.version + " " + v.size);
                        break;
                    }
                }
            }

            else if (command.equals("TOTAL_STORAGE")) {

                String file = parts[1];

                if (!storage.containsKey(file)) {
                    System.out.println("File Not Found");
                    continue;
                }

                int sum = 0;

                for (FileVersion v : storage.get(file)) {
                    sum += v.size;
                }

                System.out.println(file + " " + sum);
            }
        }

        sc.close();
    }
}