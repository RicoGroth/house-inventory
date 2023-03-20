<script lang="ts">
    import Settings from "$lib/assets/settings-cog.svg";
    import type { Item } from "$lib/Interfaces/Item";
    import type { BestBeforeDate } from "$lib/Interfaces/BestBeforeDate";

    const createItem = (
        id: string,
        name: string,
        quantity: number,
        weight: number,
        unit: string,
        day: number,
        month: number,
        year: number
    ): Item => ({
        id, 
        name, 
        quantity, 
        weight, 
        unit, 
        bestBeforeDate: {
            day: new Date(Number.parseInt(day, 10), 
            month: Number.parseInt(month, 10) - 1, 
            year: Number.parseInt(year, 10) + 2000
        }
    );

    const bestBeforeDateAsString = (date: BestBeforeDate) => {
        const obj = new Date(date.year, date.month, date.day);
        const options = {
            year: "numeric",
            month: "numeric",
            day: "numeric"
        };
        return obj.toLocaleString("de-DE", options);
    }

    let items: Item[] = [
        createItem("1", "Mehl", 3, 500, "Gramm", 27, 12, 2025),
        createItem("2", "Erbsen", 8, 250, "Gramm", 27, 12, 2025),
        createItem("3", "Möhrchen", 12, 250, "Gramm", 27, 12, 2025),
        createItem("4", "Kartoffeln in der Dose", 6, 2, "Kilo", 29, 2, 2027),
        createItem("5", "Cornflakes Natur", 2, 200, "Gramm", 10, 4, 2022),
        createItem("6", "Wasser mit Sprudel", 18, 1, "Liter", 16, 6, 2029),
        createItem("7", "Zucker", 6, 500, "Gramm", 15, 3, 2027),
    ].sort();

    let id = "";
    let name = "";
    let quantity = 0;
    let date = "";
    let unit = "";
    let weight = 0;
    const submitNewItem = () => {
        const [day, month, year] = date.split(".");
        items = [
            ...items,
            createItem(
                id, 
                name,
                quantity,
                weight,
                unit,
                Number.parseInt(day, 10),
                Number.parseInt(month, 10) - 1,
                Number.parseInt(year, 10) + 2000
            )
        ];
    };

    const isStringSet = (str: string) => str !== undefined && str !== null && str.trim() !== "";

    $: {
        const currentInputValue = date
            .replace(/[^0-9]/g, "")             // remove all non-numeric character
            .replace(/(\d{2})(?=\d)/g, "$1.")   // add dots, such that "1234567890" becomes "12.34.56.78.90"
            .substring(0, "XX.XX.XX".length);   // remove trailing characters such that "12.34.56.78.90" becomes "12.34.56"
        const [day, month, year] = currentInputValue.split(".");
        date = currentInputValue;
        console.log({date, day, month, year})
    }


</script>

<main>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Anzahl</th>
                <th>MHD</th>
                <th>Gewicht</th>
                <th>Einheit</th>
            </tr>
        </thead>
        <tbody>
            {#each items as item}
                <tr>
                    <td>{item.id}</td>
                    <td>{item.name}</td>
                    <td>{item.quantity}</td>
                    <td>{bestBeforeDateAsString(item.bestBeforeDate)}</td>
                    <td>{item.weight}</td>
                    <td>{item.unit}</td>
                </tr>
            {/each}
        </tbody>
    </table>
    <form on:submit={submitNewItem}>
    <table>
        <tbody>
            <tr>
                <td>ID</td>
                <td><input bind:value={id}></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input bind:value={name}></td>
            </tr>
            <tr>
                <td>Anzahl</td>
                <td><input type="number" bind:value={quantity}></td>
            </tr>
            <tr>
                <td>Datum</td>
                <td><input bind:value={date}></td>
            </tr>
            <tr>
                <td>Gewicht</td>
                <td><input type="number" bind:value={weight}></td>
            </tr>
            <tr>
                <td>Einheit</td>
                <td><input bind:value={unit}></td>
            </tr>
        </tbody>
    </table>
    <input type="submit" value="Hinzufügen">
    <img src={Settings} alt="Einstellungen" height="40px" width="40px"/>
    </form>
</main>

<style>
    th {
        background-color: lightgrey;
        color: black;
    }

    table {
        border-spacing: 0;
        border-collapse: collapse;
    }

    tr {
        border: 2px solid black;
    }

    td {
        padding: 10px;
    }

    tr:nth-child(odd) {
        background-color: white;
    }

    tr:nth-child(even) {
        background-color: lightgrey;
    }
</style>
