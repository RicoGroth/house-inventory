import type { Item } from "@lib/Interfaces/Item";

export const ItemsFixture: Item[]  = [
    {id: "1", name: "Dinkelmehl", category: "Mehl", weight: "500g", quantity: 3, bestBefore: new Date(2023, 11)},
    {id: "2", name: "Spaghetti", category: "Nudeln", weight: "500g", quantity: 7, bestBefore: new Date(2024, 3)},
    {id: "3", name: "Dinkelmehl", category: "Mehl", weight: "500g", quantity: 1, bestBefore: new Date(2027, 7)},
    {id: "4", name: "Gnocchi", category: "Nudeln", weight: "500g", quantity: 6, bestBefore: new Date(2023, 0)},
    {id: "5", name: "Dinkelmehl", category: "Mehl", weight: "500g", quantity: 2, bestBefore: new Date(2026, 2)},
    {id: "6", name: "Weizenmehl", category: "Mehl", weight: "1kg", quantity: 5, bestBefore: new Date(2028, 10)},
];
