import { Component, OnInit } from '@angular/core';
import { PipeTransform } from '@angular/core';
import { DecimalPipe } from '@angular/common';
import { FormControl } from '@angular/forms';

import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';
import { ItemService } from '../../services/item.service';
import { Item } from "../../models/item";

@Component({
  selector: 'app-seller-invertory',
  templateUrl: './seller-invertory.component.html',
  styleUrls: ['./seller-invertory.component.css'],
  providers: [DecimalPipe]
})
export class SellerInvertoryComponent implements OnInit {
  
  ngOnInit(){}
  items$: Observable<Item[]>;
  filter = new FormControl('');

  constructor(pipe: DecimalPipe, private itemService: ItemService) {
    // this.items$ = this.filter.valueChanges.pipe(
    //   startWith(''),
    //   map(text => this.search(text, pipe))
    // );
  }

  search(text: string, pipe: PipeTransform){
    return this.itemService.get_items().subscribe(item => {
      const term = text.toLowerCase();
      // return item.i_desc.toLowerCase().includes(term)
      //     || item.i_mft.toLowerCase().includes(term)
      //     || pipe.transform(item.i_price).includes(term)
      //     || item.i_remarks.toLowerCase().includes(term);
    });
  }
}

