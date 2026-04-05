package practice2;

import java.util.*;

// ================= PROJECT TEAM =================
class ProjectTeam {
    String teamId;
    String section;
    String domain;
    String projectName;
    int projectScore;

    public ProjectTeam(String teamId, String section, String domain, String projectName, int projectScore) {
        this.teamId = teamId;
        this.section = section;
        this.domain = domain;
        this.projectName = projectName;
        this.projectScore = projectScore;
    }
}

// ================= COMPETITION MANAGER =================
class CompetitionManager {
    List<ProjectTeam> teams = new ArrayList<>();

    // REGISTER
    public int registerTeam(String teamId, String section, String domain, String projectName, int projectScore) {
        for (ProjectTeam p : teams) {
            if (p.teamId.equals(teamId)) {
                return 0;
            }
        }
        teams.add(new ProjectTeam(teamId, section, domain, projectName, projectScore));
        return 1;
    }

    // REVISE
    public int reviseScore(String teamId, int projectScore) {
        for (ProjectTeam p : teams) {
            if (p.teamId.equals(teamId)) {
                p.projectScore = projectScore;
                return 1;
            }
        }
        return 0;
    }

    // FILTERDOMAIN
    public List<ProjectTeam> filterByDomain(String domain) {
        List<ProjectTeam> filter = new ArrayList<>();
        for (ProjectTeam p : teams) {
            if (p.domain.equals(domain)) {
                filter.add(p);
            }
        }
        return filter;
    }

    // QUALIFY
    public List<ProjectTeam> qualifyTeams(int cutoff) {
        List<ProjectTeam> qualify = new ArrayList<>();
        for (ProjectTeam p : teams) {
            if (p.projectScore >= cutoff) {
                qualify.add(p);
            }
        }
        return qualify;
    }
}

// ================= MAIN CLASS =================
public class ProjectManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CompetitionManager cm = new CompetitionManager();

        System.out.println("input");
        int n = Integer.parseInt(sc.nextLine());

        for(int i =0; i < n; i++){

            String input = sc.nextLine();
            String[] part = input.split(" ");
            String command = part[0];

            switch (command) {

                case "REGISTER":
                    cm.registerTeam(part[1], part[2], part[3], part[4], Integer.parseInt(part[5]));
                    break;

                case "REVISE":
                    String teamId = part[1];
                    int value = Integer.parseInt(part[2]);

                    if (cm.reviseScore(teamId, value) == 1) {
                        System.out.println("REVISED " + teamId + " " + value);
                    } else {
                        System.out.println("team is not available");
                    }
                    break;

                case "FILTERDOMAIN":
                    String domain = part[1];
                    List<ProjectTeam> filtered = cm.filterByDomain(domain);

                    if (filtered.isEmpty()) {
                        System.out.println("Team is not available for the domain: " + domain);
                    } else {
                        for (ProjectTeam t : filtered) {
                            System.out.println(t.teamId + " " + t.section + " " + t.domain + " " + t.projectName + " " + t.projectScore);
                        }
                    }
                    break;

                case "QUALIFY":
                    int cutoff = Integer.parseInt(part[1]);
                    List<ProjectTeam> qualified = cm.qualifyTeams(cutoff);

                    if (qualified.isEmpty()) {
                        System.out.println("No team qualified");
                    } else {
                        for (ProjectTeam t : qualified) {
                            System.out.println(t.teamId + " " + t.section + " " + t.domain + " " + t.projectName + " " + t.projectScore);
                        }
                    }
                    break;
            }
        }
    }
}