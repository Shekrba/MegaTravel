import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-agent',
  templateUrl: './agent.component.html',
  styleUrls: ['./agent.component.sass']
})
export class AgentComponent implements OnInit {
  
  constructor(private toastr: ToastrService) {}

  showSuccess() {
    if(1){
      this.toastr.success("Agent registration successful.", "Registration");
      
    }
  }

  ngOnInit() {
  }

}
