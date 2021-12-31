import fs from 'fs';
import os from 'os';

export function readLines(file: string) {
  return fs.readFileSync(file, 'utf8').split(os.EOL);
}