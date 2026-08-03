import { api } from "../../../shared/services/api";
import type { WordResponse } from "../types/wordResponse";

export const getTodayWords = async (): Promise<WordResponse[]> => {
    try {
        const response = await api.get<WordResponse[]>("words/today");

        return response.data;
    } catch (error) {
        console.error("Error sending prompt:", error);

        throw error;
    }
};