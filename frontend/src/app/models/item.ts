import { Cart } from './cart';

export class Item{
    i_id: number;
    i_name:string;
    i_category_id: number;
    i_subcategory_id: number;
    i_price: number;
    i_desc: string;
    i_mft: string;
    i_stock_num: number;
    i_remarks: string;
    cart: Cart
}