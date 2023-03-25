<script lang="ts">
import ItemTable from "@components/ItemTable.svelte";
import { ItemsFixture } from "@fixtures/Items";
import type { Item } from "@interfaces/Item";

const headers = ["Kategorie", "Name", "Gewicht", "Anzahl", "Ablaufdatum"];
let items = ItemsFixture;
const keys = items.map((item: Item) => Object.keys(item)); 
console.log({keys});
const byCategory = (a: Item, b: Item) => a.category.localeCompare(b.category);
const byName = (a: Item, b: Item) => a.name.localeCompare(b.name);
$: {
    items.sort(byName);
}
</script>

<main>
<ItemTable items={ItemsFixture} headers={headers}/>
</main>

<style>
</style>
