export class Patient {
  id: number;
  firstName: string;
  lastName: string;
  sex: string;
  birthday: Date;
  country: string;
  state: string;
  address: string;
  // isShowed: boolean = true;
  // status: string = "d-sm-block";
  // style_display: string = "block";


  constructor() {
    this.firstName = '';
    this.lastName = '';
    this.country = '';
    this.state = '';
    this.address = '';
  }
}
