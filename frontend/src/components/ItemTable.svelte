<script lang="ts">
import type { Item } from "@interfaces/Item";
import { TableLayout } from "@classes/TableLayout";

export let items: Item[];
export let headers: string[];

const formatBestBefore = (bestBefore: Date) => bestBefore.toLocaleDateString("de-DE", {
    year: "numeric",
    month: "long"
});
</script>

<table>
<thead>
    <tr>
        {#each headers as header}
            <th>{header}</th>
        {/each}
    </tr>
</thead>
<tbody>
    {#each items as item}
        <tr>
            <td>{item.category}</td>
            <td>{item.name}</td>
            <td>{item.weight}</td>
            <td>{item.quantity}</td>
            <td>{formatBestBefore(item.bestBefore)}</td>
        </tr>
    {/each}
</tbody>
</table>

<style>
table {
    border-collapse: collapse;
}

td {
    padding: 10px 50px;
}

tr:nth-child(odd) {
    background-color: lightgrey;
}

tr:nth-child(even) {
    background-color: white;
}
</style>
