import { Component, OnInit } from '@angular/core';
import { FormBuilder } from "@angular/forms";
import { ItemService } from "../../services/item.service";

@Component({
  selector: 'app-seller-add',
  templateUrl: './seller-add.component.html',
  styleUrls: ['./seller-add.component.css']
})
export class SellerAddComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, 
              private itemService:ItemService) { }
  addItemForm;

  ngOnInit() {
    this.addItemForm = this.formBuilder.group({
      i_name:'',
      i_category_id: '',
      i_subcategory_id: '',
      i_price: '',
      i_desc: '',
      i_mft: '',
      i_stock_num: '',
      i_remarks: ''

    })
  }

  onSubmit(item){
    
    this.itemService.add_item(item).subscribe(data =>{
      console.log("seller add page-onSubmit response:"+JSON.stringify(data));
      if(JSON.stringify(data).indexOf("i_id")>-1){
        window.alert("add item successfully!");
      }else{
        window.alert("add item failed, please try again!");
      }
    })
  }

}
