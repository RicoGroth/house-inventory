import type { Item } from "@interfaces/Item";

interface Column {
    readonly name: string;
    readonly key: string;
    readonly position: number;
};

export class TableLayout {
    private static instance: TableLayout | null = null;
    private headerMap: {key: string, value: string}[];

    private constructor(layoutDefinition: Column[]) {
    }

    public static getInstance(layoutDefinition: Column[]) {
        if(TableLayout.instance === null) {
            TableLayout.instance = new TableLayout(layoutDefinition);
        }
        return TableLayout.instance;
    }

    public fromItemToSortedArray(item: Item): (string|number)[] {
        return [];
    }
}
