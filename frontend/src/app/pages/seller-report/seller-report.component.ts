import { Component, OnInit } from '@angular/core';
import { ItemService } from '../../services/item.service';
import { Item } from "../../models/item";

@Component({
  selector: 'app-seller-report',
  templateUrl: './seller-report.component.html',
  styleUrls: ['./seller-report.component.css']
})
export class SellerReportComponent implements OnInit {
  items: Item[];
  constructor(private itemService: ItemService) { }

  ngOnInit() {
    // this.items = this.itemService.get_items();
  }

}
