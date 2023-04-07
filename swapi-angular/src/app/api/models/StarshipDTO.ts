/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */

import type { SearchItemDTO } from './SearchItemDTO';

export type StarshipDTO = {
    MGLT?: string;
    cargo_capacity?: string;
    cost_in_credits?: string;
    hyperdrive_rating?: string;
    maxAtmospheringSpeed?: string;
    starship_class?: string;
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

