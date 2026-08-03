import { useEffect, useState } from "react";
import type { WordResponse } from "../types/wordResponse";
import { getTodayWords } from "../services/wordService";

export default function useGetTodayWords() {
    const [todayWords , setTodayWords] = useState<WordResponse[]>([]);

    useEffect(() => {
        const fetchWords = async () => {
            try {
                const data = await getTodayWords();

                setTodayWords(data);
            } catch (error) {
                console.error(error);
            }
        };

        fetchWords();
    } , []);

    return {
        todayWords
    }
}