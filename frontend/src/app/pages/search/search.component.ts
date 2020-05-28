import { Component, OnInit } from '@angular/core';
import { ItemService } from '../../services/item.service';
import { Item } from "../../models/item";
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private itemService: ItemService,
    private router: Router) { }
  items: any;
  startPrice: number;
  endPrice: number;
  selectedManufacturer: string;
  manufacturers:any;

  ngOnInit() {
    let out_this = this;
    this.itemService.get_items().subscribe(data =>{
      console.log("search page-ngoninit:"+JSON.stringify(data));
      out_this.items = data;
    })
    this.itemService.get_manufactures().subscribe(data =>{
      console.log("search page-ngoninit:"+JSON.stringify(data));
      out_this.manufacturers = data;
      out_this.selectedManufacturer=out_this.manufacturers[0];
    })
    this.startPrice=0;
    this.endPrice=0;
    
  }

  changeSelction(manufacturer: string){
    this.selectedManufacturer = manufacturer;
  }

  search(){
    console.log("search function in:");
    let param: any = {
      startPrice:this.startPrice,
      endPrice: this.endPrice,
      manufacture: this.selectedManufacturer
    }
    console.log("search page-search function-selected manufacture:"+this.selectedManufacturer);
    this.items = this.itemService.filter_items(param).subscribe(data =>{
      console.log("search page-response of search:"+JSON.stringify(data));
      this.items = data;
    })
  }

  checkDetail(id: number){
    this.router.navigate(['/detail/:'+id]);
    // console.log("search page-check detail-id:"+id);
    // this.itemService.get_item(id).subscribe(data=>{
    //   console.log("search page-response of check detail:"+JSON.stringify(data));
    //   this.router.navigate(['/search']);
    // })
  }


}
