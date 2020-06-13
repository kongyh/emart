import { Item } from "../../models/item";

const items_list: Item[] =[
    {
        i_id: 1,
        i_name:"watch",
        i_category_id: 100,
        i_subcategory_id: 100100,
        i_price: 123.889,
        i_desc: "watch",
        i_mft: "tao bao",
        i_stock_num: 1000,
        i_remarks: "so so",
        cart:null
    },{
        i_id: 2,
        i_name:"watch",
        i_category_id: 100,
        i_subcategory_id: 100100,
        i_price: 50780.289,
        i_desc: "watch",
        i_mft: "tian mao",
        i_stock_num: 1001,
        i_remarks: "better",
        cart:null
    },{
        i_id: 3,
        i_name:"watch",
        i_category_id: 100,
        i_subcategory_id: 100100,
        i_price: 500800.289,
        i_desc: "watch",
        i_mft: "tian suo",
        i_stock_num: 1002,
        i_remarks: "great",
        cart:null
    }
]

export{ items_list }