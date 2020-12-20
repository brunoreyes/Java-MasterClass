package com.company;

public class Main {

    public static void main(String[] args) {
        // Create a generic class to implement a league table for a sport.
        // The class should allow teams to be added to the list, and store
        // a list of teams that belong to the league.
        //
        // Your class should have a method to print out the teams in order,
        // with the team at the top of the league printed first.
        //
        // Only teams of the same type should be added to any particular
        // instance of the league class - the program should fail to compile
        // if an attempt is made to add an incompatible team.

        // using generics to specify the type of team (one of which only football players are allowed)
        League<Team<FootballPlayer>> footballLeague = new League<>("NFL");

        Team<FootballPlayer> minnesotaVikings = new Team<>("Minnesota Vikings");
        Team<FootballPlayer> newYorkGiants= new Team<>("New York Giants");
        Team<FootballPlayer> newEnglandPatriots= new Team<>("New York Giants");
        Team<FootballPlayer> philadelphiaEagles= new Team<>("Philadelphia Eagles");

        footballLeague.add(minnesotaVikings);
        footballLeague.add(newYorkGiants);
        footballLeague.add(newEnglandPatriots);
        footballLeague.add(philadelphiaEagles);

        minnesotaVikings.matchResult(newYorkGiants,0,2); // team1.matchResult(team2, team1Pts, team2Pts)
        newEnglandPatriots.matchResult(philadelphiaEagles,4,3);
        footballLeague.showLeagueTable(); // retrieves team wins


        League<Team<BaseballPlayer>> baseballLeague = new League<>("MLB");

        Team<BaseballPlayer> minnesotaTwins = new Team<>("Minnesota Twins");
        Team<BaseballPlayer> saintPaulSaints= new Team<>("Saint Paul Saints");
        Team<BaseballPlayer> bostonRedSocks= new Team<>("Boston Red Socks");
        Team<BaseballPlayer> newYorkYankees= new Team<>("New York Yankees");

        baseballLeague.add(minnesotaTwins);
        baseballLeague.add(saintPaulSaints);
        baseballLeague.add(bostonRedSocks);
        baseballLeague.add(newYorkYankees);

        minnesotaTwins.matchResult(saintPaulSaints,10,1);
        bostonRedSocks.matchResult(newYorkYankees,4,6);
        baseballLeague.showLeagueTable(); // a win is 2 pts, a tie is 1pt


        // This is what can happen w/o the use of generics, the code will run w/ unchecked warnings
        // allowing parts of different sports to merge b/c raw types are being used instead of generics
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");
        Team rawTeam = new Team("Raw Team");
        rawTeam.addPlayer(beckham); // unchecked warning
        rawTeam.addPlayer(pat);     // unchecked warning

        footballLeague.add(rawTeam);     // unchecked warning

        League<Team> rawLeague = new League<>("Raw"); // <> = raw types, anything can come in
       // League<FootballPlayer, Team<FootballPlayer>> rawLeague = new League<>("Raw"); // when League's U extends Player
        rawLeague.add(minnesotaTwins);     // no warning
        rawLeague.add(minnesotaVikings);    // no warning
        rawLeague.add(rawTeam);         // no warning

        League reallyRaw = new League("Really raw");
        reallyRaw.add(newEnglandPatriots);     // unchecked warning
        reallyRaw.add(saintPaulSaints);    // unchecked warning
        reallyRaw.add(rawTeam);         // unchecked warning




    }
}
