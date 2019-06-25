export interface User {
    id: number;
    username: string;
    ime: string;
    prezime: string;
    token?: string;
    expiresIn?:number;
}