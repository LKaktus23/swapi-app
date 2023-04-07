/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */

import type { SearchItemDTO } from './SearchItemDTO';

export type VehicleDTO = {
    cost_in_credits?: string;
    max_atmosphering_speed?: string;
    vehicle_class?: string;
    consumables?: string;
    created?: string;
    crew?: string;
    edited?: string;
    length?: string;
    manufacturer?: string;
    model?: string;
    name?: string;
    passengers?: string;
    url?: string;
    films?: Array<string>;
    filmItems?: Array<SearchItemDTO>;
    pilots?: Array<string>;
    pilotItems?: Array<SearchItemDTO>;
};

