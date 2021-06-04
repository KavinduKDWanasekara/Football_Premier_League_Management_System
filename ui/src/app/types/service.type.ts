export interface IService {
    clubName: string;
    location: string;
    Topoints: number;
    numOfWins: number;
    numOfDefeats: number;
    numOfDraws: number;
    numOfGoalsReceived: number;
    numOfGoalsScored: number;
    numberOfMatches: number;
    goalDifference: number;

    // "clubName": "kavindu",
    //     "location": "wansekara",
    //     "ToPoints": 406,
    //     "numOfWins": 101,
    //     "numOfDefeats": 101,
    //     "numOfDraws": 100,
    //     "numOfGoalsReceived": 129,
    //     "numOfGoalsScored": 240,
    //     "numberOfMatches": 302,
    //     "goalDifference": 111,
    //     "toPoints": 403
}

// interface Date {
//     day: number;
//     month: number;
//     year: number;
//   }

export interface Imatch {
    Date: any;
    team1: string;
    team2: string;
    team1Goals: number;
    team2Goals: number;
    matchStadium: string;
    date: Date;
}