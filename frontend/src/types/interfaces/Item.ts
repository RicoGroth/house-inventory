export interface Item {
    readonly id: string;
    readonly category: string;
    readonly name: string;
    readonly quantity: number;
    readonly weight: number,
    readonly bestBefore: Date;
};
